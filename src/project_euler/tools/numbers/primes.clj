(ns project-euler.tools.numbers.primes)

(defn- divisible-by
  [x y]
  (zero? (mod x y)))

(defn- floor
  [n]
  (int (Math/floor n)))

(defn primes*
  "Returns an infinite seq of prime numbers. Lazy."
  ([]
   (cons 2 (lazy-seq (primes* [2] 3))))
  ([primes candidate]
   (if (not-any? #(divisible-by candidate %) primes)
     (cons candidate (lazy-seq (primes* (cons candidate primes) (+ 2 candidate))))
     (lazy-seq (primes* primes (+ 2 candidate))))))

(def primes (primes*))

(defn factorize
  "Returns a vector of the prime factors of `n`."
  ([n]
   (factorize n primes []))
  ([n [x & xs :as candidates] factors]
   (cond
     ; No factors or fully factorized.
     (<= n 1)
     factors
     ; Multiple instances of candidate prime factor.
     (divisible-by (/ n x) x)
     (recur (/ n x) candidates (conj factors x))
     ; Single instance of candidate prime factor.
     (divisible-by n x)
     (recur (/ n x) xs (conj factors x))
     ; Candidate prime is not a factor.
     :else
     (recur n xs factors))))

(defn sieve
  "Returns a vector of prime numbers between 2 and `n` inclusive."
  ([n]
   (if (< n 2)
     []
     (sieve [2] (range 3 (inc n) 2) (Math/sqrt n))))
  ([primes [x & xs :as candidates] stop]
   (cond
     ; All candidates have been processed.
     (empty? candidates)
     primes
     ; Hit the stopping point, so remaining candidates must be prime.
     (> x stop)
     (concat primes candidates)
     ; Filter out multiples of current prime `x`.
     :else
     (recur (conj primes x) (filter #((complement divisible-by) % x) xs) stop))))

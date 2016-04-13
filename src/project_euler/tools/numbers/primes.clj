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
   (lazy-seq (cons 2 (primes* [2] 3))))
  ([primes candidate]
   (if (not-any? #(divisible-by candidate %) primes)
     (lazy-seq (cons candidate (primes* (cons candidate primes) (+ 2 candidate))))
     (lazy-seq (primes* primes (+ 2 candidate))))))

(def primes (primes*))

(defn factorize
  "Returns a vector of the prime factors of `n`."
  [n]
  (loop [factors []
         [x & xs :as candidates] primes
         current n]
    (cond
      ; No factors or fully factorized.
      (<= current 1)
      factors
      ; Multiple instances of candidate prime factor.
      (divisible-by (/ current x) x)
      (recur (conj factors x) candidates (/ current x))
      ; Single instance of candidate prime factor.
      (divisible-by current x)
      (recur (conj factors x) xs (/ current x))
      ; Candidate prime is not a factor.
      :else
      (recur factors xs current))))

(defn sieve
  "Returns a vector of prime numbers between 2 and `n` inclusive."
  [n]
  (if (< n 2)
    []
    (loop [primes [2]
           [x & xs :as candidates] (range 3 (inc n) 2)
           stop (Math/sqrt n)]
      (cond
        ; All candidates have been processed.
        (empty? candidates)
        primes
        ; Hit the stopping point, so remaining candidates must be prime.
        (> x stop)
        (concat primes candidates)
        ; Filter out multiples of current prime `x`.
        :else
        (recur (conj primes x) (filter #((complement divisible-by) % x) xs) stop)))))

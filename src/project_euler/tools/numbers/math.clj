(ns project-euler.tools.numbers.math
  (:require [clojure.math.combinatorics :as combo]
            [project-euler.tools.numbers.primes :as primes]))

(defn factorial
  "Returns the factorial of the number `n`."
  [n]
  (reduce * (range 1N (inc n))))

(defn divisors
  "Returns a sorted-set of the divisors of `n` (including 1 and `n`)."
  [n]
  (->> (primes/factorize n)
       (combo/subsets) ; TODO: Implement my own version of something similar (e.g. power-set).
       (map (partial reduce *))
       (filter (complement zero?))
       (cons 1)
       (into (sorted-set))))

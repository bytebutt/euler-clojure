(ns project-euler.problems.problem-005
  (:require [project-euler.tools.numbers.primes :as primes]))

(defn smallest-multiple
  [xs]
  (let [factors (map primes/factorize xs)
        prime-freqs (map (comp vec frequencies) factors)
        flat-freqs (partition 2 (flatten prime-freqs))
        sorted-prime-groups (map #(sort-by second %) (vals (group-by first flat-freqs)))
        max-prime-freqs (map last sorted-prime-groups)]
    (reduce (fn [product [prime freq]]
              (* product (int (Math/pow prime freq))))
            1
            max-prime-freqs)))

; Compute answer.
(defn solve []
  (smallest-multiple (range 1 21)))

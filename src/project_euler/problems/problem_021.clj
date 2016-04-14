(ns project-euler.problems.problem-021
  (:require [project-euler.tools.numbers.math :as math]))

(defn divisor-sum
  [n]
  (let [divs (filter (partial not= n) (math/divisors n))]
    (reduce + divs)))

(defn amicable?
  [n]
  (let [dsum (divisor-sum n)]
    (and (not= 0 dsum)
         (not= n dsum)
         (= n (divisor-sum dsum)))))

(defn solve []
  (->> (range 1 10000)
       (filter amicable?)
       (reduce +)))

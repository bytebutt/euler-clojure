(ns project-euler.problems.problem-014
  (:require [project-euler.tools.numbers.collatz :as collatz]))

(defn collatz-count
  "Returns a vector of `n` and the length of the Collatz sequence produced using `n`
  as the initial value."
  [n]
  (vector n (count (collatz/collatz n))))

(defn solve []
  (->> (range 1 1000000)
       (map collatz-count)
       (sort-by second)
       (last)
       (first)))

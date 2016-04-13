(ns project-euler.problems.problem-012
  (:require [project-euler.tools.numbers.math :as math]
            [project-euler.tools.numbers.triangular :as tri]))

(defn solve []
  (->> tri/triangular
       (drop-while #(>= 500 (count (math/divisors %))))
       (first)))

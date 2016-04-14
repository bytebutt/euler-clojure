(ns project-euler.problems.problem-016
  (:require [project-euler.tools.numbers.math :as math]))

(defn solve []
  (->> (math/pow 2 1000)
       (str)
       (map str)
       (map bigint)
       (reduce +)))

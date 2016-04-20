(ns project-euler.problems.problem-040
  (:require [project-euler.tools.numbers.champernowne :refer [champernowne-digit]]))

(defn solve []
  (->> [1 10 100 1000 10000 100000 1000000]
       (map champernowne-digit)
       (reduce *)))

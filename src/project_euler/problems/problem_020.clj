(ns project-euler.problems.problem-020
  (:require [project-euler.tools.numbers.math :as math]))

(defn num->vec
  "Takes a number `n` and returns a vector of the digits of `n`."
  [n]
  (reduce (fn [v digit]
            (conj v (Integer. (str digit))))
          []
          (str n)))

(defn solve []
  (->> (math/factorial 100)
       (num->vec)
       (reduce +)))

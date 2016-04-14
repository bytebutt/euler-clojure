(ns project-euler.tools.counting
  (:require [project-euler.tools.numbers.math :as m]))

(defn binomial
  [n k]
  (/ (m/factorial n)
     (* (m/factorial k) (m/factorial (- n k)))))

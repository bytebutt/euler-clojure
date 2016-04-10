(ns project-euler.problems.problem-025
  (:require [project-euler.tools.numbers.fibonacci :as fib]))

(defn digits
  [n]
  (count (str n)))

(defn solve []
  (loop [index 1
         [x & xs] fib/fibonacci]
    (if (= 1000 (digits x))
      index
      (recur (inc index) xs))))

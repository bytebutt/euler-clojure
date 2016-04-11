(ns project-euler.problems.problem-002
  (:require [project-euler.tools.numbers.fibonacci :as fib]))

(defn solve []
  (->> fib/fibonacci
       (take-while #(< % 4000000))
       (filter even?)
       (reduce +)))

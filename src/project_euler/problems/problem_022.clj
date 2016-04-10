(ns project-euler.problems.problem-022
  (:require [clojure.string :as s]
            [clojure.java.io :as io]))

(def names
  (-> (io/resource "input/problem_022.txt")
      (slurp)
      (s/replace #"\"" "")
      (s/split #",")))

(defn name->value
  [name]
  (->> name
       (map int)
       (map #(- % 64))
       (reduce +)))

(defn solve []
  (let [values (map name->value (sort names))
        positions (range 1 (inc (count values)))
        weighted-values (map vector values positions)]
    (reduce (fn [sum [value weight]]
              (+ sum (* value weight)))
            0
            weighted-values)))

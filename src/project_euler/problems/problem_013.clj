(ns project-euler.problems.problem-013
  (:require [clojure.java.io :as io]
            [clojure.string :as s]))

(def numbers
  (reduce (fn [xs n]
            (conj xs (BigInteger. n)))
          []
          (-> (io/resource "input/problem_013.txt")
              (slurp)
              (s/split #"\n"))))

(defn solve []
  (->> numbers
       (reduce +)
       (str)
       (take 10)
       (apply str)))

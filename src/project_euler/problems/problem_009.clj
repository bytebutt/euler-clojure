(ns project-euler.problems.problem-009
  (:require [clojure.math.combinatorics :as combo]))

(defn pythagorean-triplet?
  [a b c]
  (let [square #(* % %)]
    (= (+ (square a) (square b)) (square c))))

(defn solve []
  (->> (combo/combinations (range 1 1001) 3) ; TODO: Finding all combinations is probably excessive.
       (filter #(apply pythagorean-triplet? %))
       (filter #(= 1000 (reduce + %)))
       (first)
       (reduce *)))

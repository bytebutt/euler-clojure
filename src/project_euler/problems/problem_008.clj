(ns project-euler.problems.problem-008
  (:require [clojure.java.io :as io]
            [clojure.string :as s]))

(def number-string
  (-> (io/resource "input/problem_008.txt")
      (slurp)
      (s/replace #"\n" "")))

(defn adjacent-elements
  ([xs width]
   (adjacent-elements xs width []))
  ([xs width neighbors]
   (let [chunk (take width xs)]
     (if (< (count chunk) width)
       neighbors
       (recur (rest xs) width (conj neighbors chunk))))))

(defn str->int [s] (Integer. (str s)))

(defn solve []
  (->> (adjacent-elements number-string 13)
       (map (partial map str->int))
       (map (partial reduce *))
       (apply max)))

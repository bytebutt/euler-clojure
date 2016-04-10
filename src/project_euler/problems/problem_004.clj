(ns project-euler.problems.problem-004)

(defn palindromic-number?
  "Returns true if a number reads the same both forwards and backwards (e.g. 12321). False otherwise."
  [n]
  (let [s (seq (str n))]
    (every? identity
            (map #(= %1 %2) s (reverse s)))))

(defn pairs
  "Returns all pairs of elements in `coll`. Assumes `coll` has unique elements."
  ([coll]
   (pairs coll []))
  ([[x & xs :as coll] combos]
   (if (empty? coll)
     combos
     (recur xs (into combos (map #(list x %) coll))))))

(defn solve []
  (let [numbers (range 100 1000)
        products (into #{} (map #(* (first %) (second %)) (pairs numbers)))]
    (apply max (filter palindromic-number? products))))

(ns project-euler.problems.problem-035
  (:require [project-euler.tools.numbers.primes :as p]))

(defn rotate-left
  [s]
  (let [[x & xs] s
        rotated (conj (vec xs) x)]
    (apply str rotated)))

(defn rotations
  [s]
  (loop [rots []
         current s
         n (count s)]
    (if (zero? n)
      rots
      (recur (conj rots current) (rotate-left current) (dec n)))))

(defn circular-prime?
  [n prime-set]
  (let [rots (rotations (str n))]
    (reduce (fn [circular rot]
              (and circular (contains? prime-set (Integer. rot))))
            true
            rots)))

(defn solve []
  (let [prime-set (set (p/sieve 1000000))]
    (loop [circular 0
           [x & xs] (vec prime-set)]
       (if (nil? x)
         circular
         (if (circular-prime? x prime-set)
           (recur (inc circular) xs)
           (recur circular xs))))))

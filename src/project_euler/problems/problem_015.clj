(ns project-euler.problems.problem-015
  (:require [project-euler.tools.counting :as c]))

(defn lattice-paths
  [width height]
  (c/binomial (+ width height) width))

(defn solve []
  (lattice-paths 20 20))

(defproject project-euler "1.0.0-SNAPSHOT"
  :description "Solutions to Project Euler problems"
  :url "https://projecteuler.net/"
  :license {:name "The Unlicense (Public Domain)"
            :url "http://unlicense.org"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.combinatorics "0.1.1"]]
  :main nil
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

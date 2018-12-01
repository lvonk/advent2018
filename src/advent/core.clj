(ns advent.core
  (:gen-class))
(require '[clojure.string :as str])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn mapToFrequencies [file]
  (map #(Integer/parseInt %)
    (str/split
      (slurp file) #"\n")))

(defn dayone [file]
  (reduce +
    (mapToFrequencies file)))

(ns advent.core
  (:gen-class))
(require '[clojure.string :as str])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn dayone [file]
  (reduce +
    (map #(Integer/parseInt %)
      (str/split
        (slurp file) #"\n"))))

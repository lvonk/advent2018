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

(defn applyFrequencies [currentFrequencies changes]
  (def freqs (reduce
    #(conj %1 (+ (last %1) %2)) currentFrequencies changes))
  (cond
    (> (count freqs) 1000000000) freqs
    (= (count freqs) (count (distinct freqs))) (applyFrequencies freqs changes)
    :else (first (first (filter #(not= (first %1) (last %1)) (map vector freqs (distinct freqs)))))
    ))

(defn calibrate [file]
  (applyFrequencies [0] (mapToFrequencies file)))

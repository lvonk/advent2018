(ns advent.core-test
  (:require [clojure.test :refer :all]
            [advent.core :refer :all]))

(deftest dayone-test
  (testing "summing"
    (is (= 580 (dayone "./resources/input_day_1.txt")))
  )
)
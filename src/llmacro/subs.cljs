(ns llmacro.subs
  (:require
    [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::history
  (fn [db]
    (:history db)))

(re-frame/reg-sub
  ::colours
  (fn [db]
    (rand-nth [["#BA6B68" "#A5B88C"]
               ["#907D8C" "#A5A587"]
               ["#E07A5F" "#5E7F7C"]
               ["#DAA03D" "#5B6D8E"]
               ["#D08CA6" "#86A49C"]
               ["#B36A5E" "#717D7E"]
               ["#A17E8D" "#698474"]
               ["#8E6D5B" "#7693A4"]])))


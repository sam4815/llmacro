(ns llmacro.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-event-db
  :history-change
  (fn [db [_ new-history]]
    (assoc db :history new-history)))

(re-frame/reg-sub
 ::history
 (fn [db]
   (:history db)))

(ns llmacro.events
  (:require
    [re-frame.core :as re-frame]
    [llmacro.db :as db]
    ))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))

(re-frame/reg-event-db
  :history-change
  (fn [db [_ new-history]]
    (assoc db :history new-history)))


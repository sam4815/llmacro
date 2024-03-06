(ns llmacro.views
  (:require
    [re-frame.core :as re-frame]
    [llmacro.subs :as subs]))

(defn chat [text]
  (.then (js/pipeline "text-generation" "Xenova/distilgpt2")
         (fn [text-generator]
           (.then (text-generator. text)
                  (fn [result]
                    (let [generated-text ^js/String (.-generated_text (first result))]
                      (re-frame/dispatch [:history-change generated-text])))))))

(defn main-panel []
  (let [history (re-frame/subscribe [::subs/history])]
    [:div.bg-light.container-fluid.vh-100.d-flex.flex-column
     {:on-click (fn [event]
                  (.preventDefault event)
                  (if (not= (.-id (.-activeElement js/document)) "input") (.focus (.getElementById js/document "input"))))
      :style {:cursor "pointer"}}
     [:div.bg-light.m-auto.h-50.d-flex
      [:span.border-0.m-auto.d-block
       {:style {:outline "none"}
        :contentEditable "true"
        :type "text"
        :id "input"
        :on-key-down (fn [e]
                       (if (= (.-key e) "Enter")
                         (do (.preventDefault e)
                         (chat (.-textContent (.-currentTarget e)))))) }
       ]]
     [:div.h-50.d-flex
      [:div.m-auto @history]
      ]
     ]))


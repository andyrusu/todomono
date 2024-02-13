(ns todo.components
  {:clj-kondo/ignore [:unresolved-symbol]}
  (:require [dumdom.core :as dumdom :refer [defcomponent]]))

(defcomponent heading [data]
  [:h1.title (:title data)])

(defcomponent input [data]
  [:input.input (:options data)])

(defcomponent button [data]
  [:button.button (:options data) (:text data)])

(defcomponent add-new-item [data]
  [:div.field.has-addons
   [:div.control.is-expanded
    [input (:input data)]]
   [:div.control
    [button (:button data)]]])

(defcomponent list-item [data]
  [:div.column.is-12
   [:div.box
    [:label.checkbox
     [:input {:type "checkbox"}]
     [:span (:title data)]]
    [:button.button.is-danger.is-small.is-pulled-right (:delete-label data)]]])

(defcomponent page [data]
  [:section.section
   [:div.container
    [heading (:heading data)]
    [add-new-item (:add-new-item data)]
    [:div.columns.is-multiline
     (for [item (:items data)]
       [list-item item])]]])

(defn generate-exports
  "Used to generate the list of exported components for the library"
  []
  #js {:heading heading
       :input input
       :button button 
       :add-new-item add-new-item})
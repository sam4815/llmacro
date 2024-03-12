![deploy](https://github.com/sam4815/llmacro/actions/workflows/deploy.yaml/badge.svg)

# llmacro

[demo](https://sam4815.github.io/llmacro)

## About

This is a small project intended to explore how far the in-browser LLM experience has come over the past couple of years. It uses [transformers.js](https://github.com/xenova/transformers.js) to download a model and run inference entirely within the browser (leveraging WebAssembly). The model used is [distilgpt2](https://huggingface.co/distilbert/distilgpt2) to keep bandwidth small and responses relatively fast. I might add the ability to specify the model through the UI at some point in the future - but for now, being able to change the model in a single line of code is enough for testing purposes.

I've also been enjoying Clojure recently, so I used this project as an opportunity to explore the ClojureScript ecosystem with the help of [shadow-cljs](https://github.com/thheller/shadow-cljs). JavaScript interop was trickier than I expected - especially when importing NPM packages - but playing around with familiar React concepts in a more functional style through [Reagent](https://reagent-project.github.io/) was a fun experience.


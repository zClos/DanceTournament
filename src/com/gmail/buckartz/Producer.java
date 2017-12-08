package com.gmail.buckartz;

public class Producer {

    private String name;
    private String type;

    private Producer(ProducerBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public static class ProducerBuilder {

        private String name;
        private String type;

        public ProducerBuilder(String name) {
            this.name = name;
        }

        public ProducerBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public Producer build() {
            return new Producer(this);
        }

    }
}

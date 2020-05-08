package com.pluralsight.java.moreobjectoriented;

public class OptionalsDemo {
    private static abstract class MayBeString {
        public abstract MayBeString toUpperCase();

        public abstract String orElse(String substitute);
    }

    private static class Some extends MayBeString {
        private String content;

        public Some(String content) {
            this.content = content;
        }

        @Override
        public MayBeString toUpperCase() {
            return new Some(this.content.toUpperCase());
        }

        @Override
        public String orElse(String substitute) {
            return this.content;
        }
    }

    private static class None extends MayBeString {

        public None() {
        }

        @Override
        public MayBeString toUpperCase() {
            return this;
        }

        @Override
        public String orElse(String substitute) {
            return substitute;
        }
    }

    private void display(MayBeString value) {
        MayBeString uppercase = value.toUpperCase();
        String printout = uppercase.orElse("Nothing to show...");
        System.out.println(printout);
    }

    public void run() {
        this.display(new None());
        this.display(new Some("Something"));
        this.display(new Some("Making your java code more object-oriented"));
    }

    public static void main(String[] args) {
        new OptionalsDemo().run();
    }
}

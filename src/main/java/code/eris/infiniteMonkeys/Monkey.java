package code.eris.infiniteMonkeys;

import java.lang.Math;

public class Monkey extends Thread {
    // delay between 'key' presses
    private final long delay;

    /**
     * Makes a new metaphorical monkey
     * @param delay delay of the monkey's keypresses
     */
    public Monkey(long delay) {
        this.delay = delay;
    }

    /**
     * generates a random character from the metaphorical monkey
     * @return random capital letter, a space, or a newline
     */
    private char getChar() {
        char c = 0;

        // loops til a character thats a (capital) letter is produced, or whitespace.
        while(!((c >= 'A' && c <= 'Z') || c == ' ' || c == '\n')) {
            double x = Math.random();
            c = (char) (255 * x);
        }

        return c;
    }

    /**
     * Starts the monkeys typing, multithreaded, and goes on forever!
     * However the monkey only presses one key per 'delay' milliseconds!
     */
    @Override
    public void run() {
        while (true) {
            // prints random character
            System.out.print(getChar());
            
            // tries to delay by 'delay' milliseconds 
            try {
                Thread.sleep(delay);
            } catch(InterruptedException e) {
                System.err.println("Monkey died!\nHere's why: \n" + e.getMessage());
            }
        }
    }
}

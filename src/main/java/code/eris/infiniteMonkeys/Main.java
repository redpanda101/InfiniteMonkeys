/*
 * Infinite monkey program
 * Made as a semi-joke on the infinite monkey hypothesys
 * 
 * Made by Eris Mathison
 * (c) 2022, MIT LICENSE
 */

package code.eris.infiniteMonkeys;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        // delay in ms, and default delay if delay isn't specified
        final long delay;
        final long defaultDelay = 100;


        if(args.length <= 1) {
            // temporary variable
            long _delay;

            // tries to make the first argument the delay
            // if the first argument isnt a number, use defaultDelay
            try {
                _delay = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println(args[0] + " is not an integer! using default delay of 100ms");
                _delay = defaultDelay;
            } catch (Exception e) {
                System.err.println("Using default delay of 100ms");
                _delay = defaultDelay;
            }

            // sets delay to temp delay
            delay = _delay;
        } else {
            delay = defaultDelay;
        }

        // creates new hypothetical 'monkeys'
        // and starts their typing
        Monkey[] monkeys = new Monkey[8];
        for(Monkey monkey : monkeys) {
            monkey = new Monkey(delay);
            monkey.start();
        }

        // waits for a newline to exit.
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
        System.exit(0);
    }
}

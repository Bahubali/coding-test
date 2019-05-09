package com.stack.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by bahubali.n on 25/03/19.
 */
public class NormalizePathname {
    public static void main(String[] args) throws Exception {
        String pathname = "scripts//./../scripts/awkscripts/././";
        System.out.println(normalizedPath(pathname));
    }

    public static String normalizedPath(String pathname) throws Exception {
        Deque<String> listOfDir = new LinkedList<>();

        if (pathname.length() == 0) return "";

        if (pathname.startsWith("/")) {
            listOfDir.addFirst("/");
        }

        for (String token : pathname.split("/")) {
            if (token.equals("..")) {
                if (listOfDir.isEmpty() || listOfDir.peekFirst().equals("..")) {
                    listOfDir.addFirst(token);
                } else {
                    if (listOfDir.peekFirst().equals("/")) {
                        throw new Exception("Invalid path");
                    }
                    listOfDir.removeFirst();
                }
            } else if (!token.equals(".") && !token.isEmpty()) {
                listOfDir.addFirst(token);
            }
        }

        StringBuilder result = new StringBuilder();
        if (!listOfDir.isEmpty()) {
            Iterator<String> iter = listOfDir.descendingIterator();
            String prev = iter.next();
            result.append(prev);
            while (iter.hasNext()) {
                if (!prev.equals("/")) {
                    result.append("/");
                }
                prev = iter.next();
                result.append(prev);
            }
        }

        return result.toString();
    }
}

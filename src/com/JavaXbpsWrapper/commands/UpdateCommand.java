package com.JavaXbpsWrapper.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
public class UpdateCommand {
    public void execute() {
        // Implementation for the 'xbps-update' command
        System.out.println("Updating system ... ");
        ProcessBuilder processBuilder = new ProcessBuilder("xbps-install", "-Syu");
        processBuilder.redirectErrorStream(true);
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int exitCode = 0;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exit code: " + exitCode);

    }
}

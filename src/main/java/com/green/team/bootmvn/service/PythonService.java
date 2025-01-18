package com.green.team.bootmvn.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class PythonService {
    // 가상환경 경로
    private static final String VENV_PATH = "src/main/python/venv";

    // 스크립트 경로
    private static final String SCRIPT_PATH = "src/main/python/scripts";

    // 파이썬 스크립트 실행
    public String pythonScript(String scriptName, String... args) {
        String pythonScript = SCRIPT_PATH + "/" + scriptName + ".py";
        if (!new File(pythonScript).exists()) {
            return "[ERROR] Python script not found" + scriptName;
        }

        String pythonExecutable = getPythonExecutablePath();
        StringBuilder commandBuilder = new StringBuilder(pythonExecutable)
            .append(" ").append(pythonScript);
        for (String arg : args) {
            commandBuilder.append(" ").append(arg);
        }

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(commandBuilder.toString());
            Process process = processBuilder.start();
            // Process process = Runtime.getRuntime().exec(commandBuilder.toString());
            String output  = getProcessOutput(process);

            int exitCode = process.waitFor();
            if (exitCode == 0 ) {
                System.out.println("Script executed successfullly!");
                return output;
            } else {
                return "[ERROR] Script execution failed with exit code" + exitCode + ",\n" + output;
            }
        } catch (IOException | InterruptedException e)  {
            e.printStackTrace();
            return "[ERROR] Exception occured while executing script. \n" + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "[ERROR] 스크립트 실행 오류." + e.getMessage();
        }
    }

    // 파이썬 경로 설정
    private String getPythonExecutablePath() {
        String pythonPath = isWindows() ? "Scripts/python" : "bin/python";
        return VENV_PATH + "/" + pythonPath;
    }

    // 실행환경 확인
    private Boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    // 실행 로그 출력
    private String getProcessOutput(Process process) throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            while ((line = errorReader.readLine()) != null) {
                output.append("[Error] ").append(line).append("\n");
            }
        }

        return output.toString();
    }
}

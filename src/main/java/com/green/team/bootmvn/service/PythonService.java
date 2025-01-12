package com.green.team.bootmvn.service;

public class PythonService {
    private static final String VENV_PATH = "src/main/python/venv";

    public void pythonScript (String scriptName, String[] args) {
        try {
            Process process = Runtime.getRuntime().exec(scriptName);

        } catch (Exception e) {
            System.err.println("스크립트 실행 오류.");
        }
    }
}

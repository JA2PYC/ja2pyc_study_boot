package com.green.team.bootmvn.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class PythonVirtualEnvService {
    // VENV PATH
    private static final String VENV_PATH = "src/main/python/venv";
    private static final String REQUIREMENTS_FILE = "src/main/python/requirements.txt";

    // DEPENDENCIES Flag
    private boolean dependenciesChecked = false;

    public void runVirtualEnv() {
        boolean isVENVExists = checkVirtualEnv();

        if (!isVENVExists) {
            createVirtualEnv();
        }

        if (!dependenciesChecked) {
            checkDependencies();
        }
    }

    // 가상환경 체크
    private boolean checkVirtualEnv() {
        if (new File(VENV_PATH).exists()) {
            System.out.println("가상환경이 이미 존재합니다.");
            return true;
        } else {
            System.out.println("가상환경이 존재하지 않습니다.");
            return false;
        }
    }

    // 가상환경 생성
    private void createVirtualEnv() {
        System.out.println("가상환경을 새로 생성합니다.");
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "-m", "venv", VENV_PATH);
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("프로세스 종료 코드 : " + exitCode);
        } catch (Exception e) {
            System.out.println("가상환경 생성 실패 : " + e.getMessage());
        }
    }

    // 의존성 체크크
    private void checkDependencies() {
        dependenciesChecked = true;
    }
}

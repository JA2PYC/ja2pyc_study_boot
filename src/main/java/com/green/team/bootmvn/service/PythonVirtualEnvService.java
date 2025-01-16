package com.green.team.bootmvn.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
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
            installDependencies();
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
            if (exitCode == 0) {
                System.out.println("가상환경 생성 완료!");
            } else {
                System.out.println("가상환경 생성 중 오류 발생 / 프로세스 종료 코드 : " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("가상환경 생성 실패 : " + e.getMessage());
        }
    }

    // 의존성 설치치
    private void installDependencies() {
        // 의존성 플래그
        dependenciesChecked = true;
        File requirements = new File(REQUIREMENTS_FILE);
        if (!requirements.exists() || requirements.length() == 0) {
            System.out.println("의존성 설치를 생략합니다. / Requirements.txt를 확인해 주세요.");
            return;
        }

        System.out.println("의존성 설치를 시작합니다.");
        try {
            String installCommand = getPythonExecutablePath() + " -m pip install -r " + REQUIREMENTS_FILE;
            ProcessBuilder processBuilder = new ProcessBuilder(installCommand);
            Process process = processBuilder.start();
            printProcessOutput(process);

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("의존성 설치 완료!");
            } else {
                System.err.println("의존성 설치 중 오류 발생! exitCode : " + exitCode);
                System.exit(1);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("의존성 설치 중 오류 발생 / " + e.getMessage());
            return;
        }
    }

    // 프로세스 버퍼 출력
    private void printProcessOutput(Process process) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }
        }
    }

    // 가상환경 파이썬 경로
    private String getPythonExecutablePath() {
        String pythonPath = isWindows() ? "Scripts/python" : "bin/python";
        return VENV_PATH + "/" + pythonPath;
    }

    // 실행환경 확인
    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

}

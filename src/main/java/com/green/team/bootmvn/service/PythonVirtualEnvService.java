package com.green.team.bootmvn.service;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class PythonVirtualEnvService {
    private static final String VENV_PATH = "src/main/python/venv";
    private static final String REQUIREMENTS_FILE = "src/main/python/requirements.txt";

    public void runVirtualEnv() {
        boolean isVENVExists = checkVirtualEnv();

        if (!isVENVExists) {
            createVirtualEnv();
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

    private void createVirtualEnv() {
        System.out.println("가상환경을 새로 생성합니다.");
    }
}

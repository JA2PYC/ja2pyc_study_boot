package com.green.team.bootmvn.service;

import java.io.File;

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
    }

    // 의존성 체크크
    private void checkDependencies() {
        dependenciesChecked = true;
    }
}

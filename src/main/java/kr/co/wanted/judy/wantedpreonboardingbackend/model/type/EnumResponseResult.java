package kr.co.wanted.judy.wantedpreonboardingbackend.model.type;

import lombok.Getter;

public enum EnumResponseResult {
    ERROR(-1),
    WARNING(0),
    SUCCESS(1);

    @Getter
    private final int value;

    EnumResponseResult(int value){
        this.value = value;
    }
}

package org.seasheperd.ghostnetfishing.domain.geisternetz.model;

public enum Status {
    GEMELDET,
    BERGUNG_BEVORSTEHEND,
    GEBORGEN,
    VERSCHOLLEN;

    public boolean isFinal() {
        return this == GEBORGEN || this == VERSCHOLLEN;
    }

    public boolean isChangeable() {
        return this == BERGUNG_BEVORSTEHEND;
    }
}

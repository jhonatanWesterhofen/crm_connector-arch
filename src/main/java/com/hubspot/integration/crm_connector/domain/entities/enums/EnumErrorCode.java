package com.hubspot.integration.crm_connector.domain.entities.enums;

import com.hubspot.integration.crm_connector.domain.repositories.IEnum;

/**
 *
 * @author Jhonatan
 */
public enum EnumErrorCode implements IEnum {

    CAMPO_OBRIGATORIO("001", "É necessário informar {0}. Campo obrigatório.", 400),
    ERRO_TENTATIVAS_EXCEDIDAS("002", "Limite de tentativas excedido", 400),
    ERRO_GENERICO("003", "Thread interrompida durante o backoff.", 400),
    ERRO_INTEGRACAO_HUBSPOT("004", "Erro ao criar contato", 400);

    private final String key;
    private final String erro;
    private final int httpStatus;

    private EnumErrorCode(String key, String error, int httpStatus) {
        this.key = key;
        this.erro = error;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getKey() {
        return key;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getValue() {
        return erro;
    }

    @Override
    public boolean containsInEnum(String key) {
        return false;
    }
}
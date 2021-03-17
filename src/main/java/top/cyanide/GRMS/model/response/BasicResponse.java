package top.cyanide.GRMS.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import top.cyanide.GRMS.utils.NumUtils;
import top.cyanide.GRMS.utils.StringUtils;

/**
 * @author Bai
 */
@Component
public class BasicResponse {
    @JSONField(name = "log_id")
    @JsonProperty(value = "log_id")
    private Integer logId;
    @JSONField(name = "error_code")
    @JsonProperty(value = "error_code")
    private Integer errorCode;
    @JSONField(name = "error_msg")
    @JsonProperty(value = "error_msg")
    private String errorMessage;
    @JSONField(name = "data")
    @JsonProperty(value = "data")
    private Object data;

    public BasicResponse(Integer errorCode, String errorMessage, Object data) {
        this.logId = NumUtils.newRandomInt();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public BasicResponse() {
        this.logId = NumUtils.newRandomInt();
    }

    public static BasicResponseBuilder builder() {
        return new BasicResponseBuilder();
    }

    @Override
    public String toString() {
        return StringUtils.toString(this);
    }

    public Integer getLogId() {
        return this.logId;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Object getData() {
        return this.data;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BasicResponse)) {
            return false;
        }
        final BasicResponse other = (BasicResponse) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        final Object this$logId = this.getLogId();
        final Object other$logId = other.getLogId();
        if (this$logId == null ? other$logId != null : !this$logId.equals(other$logId)) {
            return false;
        }
        final Object this$errorCode = this.getErrorCode();
        final Object other$errorCode = other.getErrorCode();
        if (this$errorCode == null ? other$errorCode != null :
            !this$errorCode.equals(other$errorCode)) {
            return false;
        }
        final Object this$errorMessage = this.getErrorMessage();
        final Object other$errorMessage = other.getErrorMessage();
        if (this$errorMessage == null ? other$errorMessage != null :
            !this$errorMessage.equals(other$errorMessage)) {
            return false;
        }
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasicResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $logId = this.getLogId();
        result = result * PRIME + ($logId == null ? 43 : $logId.hashCode());
        final Object $errorCode = this.getErrorCode();
        result = result * PRIME + ($errorCode == null ? 43 : $errorCode.hashCode());
        final Object $errorMessage = this.getErrorMessage();
        result = result * PRIME + ($errorMessage == null ? 43 : $errorMessage.hashCode());
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public static class BasicResponseBuilder {
        private Integer logId;
        private Integer errorCode;
        private String errorMessage;
        private Object data;

        BasicResponseBuilder() {
        }

        public BasicResponse.BasicResponseBuilder logId(Integer logId) {
            this.logId = logId;
            return this;
        }

        public BasicResponse.BasicResponseBuilder errorCode(Integer errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public BasicResponse.BasicResponseBuilder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public BasicResponse.BasicResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public BasicResponse build() {
            return new BasicResponse(errorCode, errorMessage, data);
        }

        public String toString() {
            return "BasicResponse.BasicResponseBuilder(logId=" + this.logId + ", errorCode=" +
                this.errorCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data +
                ")";
        }
    }
}

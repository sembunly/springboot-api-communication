package com.bunlysem.hospital.dto;

import com.fasterxml.jackson.databind.JsonNode;

public record HealthcarePayloadRequest(
        JsonNode payload
) {
}

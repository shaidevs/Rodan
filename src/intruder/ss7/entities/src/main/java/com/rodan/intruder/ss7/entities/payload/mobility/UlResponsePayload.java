/*
 * Etisalat Egypt, Open Source
 * Copyright 2021, Etisalat Egypt and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.rodan.intruder.ss7.entities.payload.mobility;

import com.rodan.intruder.ss7.entities.payload.Ss7Payload;
import com.rodan.library.model.Constants;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Ayman ElSherif
 */
@Getter @ToString(callSuper = true)
public class UlResponsePayload extends Ss7Payload {
    private long invokeId;
    private String hlrGt;

    @Builder
    public UlResponsePayload(String localGt, long invokeId, String hlrGt) {
        super(localGt, Constants.SCCP_HLR_SSN, Constants.SCCP_MSC_SSN);
        this.invokeId = invokeId;
        this.hlrGt = hlrGt;
    }

    @Override
    public boolean isAbuseOpcodeTagForBypass() {
        return false;
    }

    @Override
    public boolean isMalformedAcnForBypass() {
        return false;
    }

    @Override
    public String getPayloadName() {
        return Constants.UL_RESPONSE_PAYLOAD_NAME;
    }

    public UlResponsePayload withInvokeId(long invokeId) {
        return this.invokeId == invokeId ? this : new UlResponsePayload(getLocalGt(), invokeId, hlrGt);
    }
}

package com.tourmade.crm.common.framework.util;

public class DataUtil {
	public static int bytesToInt(byte[] array, int offset, boolean lowToHigh) {
		int b1 = 0, b2 = 0, b3 = 0, b4 = 0;

		if (!lowToHigh) {
			b1 = (array[offset++] << 24) & 0xFF000000;
			b2 = (array[offset++] << 16) & 0x00FF0000;
			b3 = (array[offset++] << 8) & 0x0000FF00;
			b4 = (array[offset++] << 0) & 0x000000FF;
		} else {
			b1 = (array[offset + 3] << 24) & 0xFF000000;
			b2 = (array[offset + 2] << 16) & 0x00FF0000;
			b3 = (array[offset + 1] << 8) & 0x0000FF00;
			b4 = (array[offset + 0] << 0) & 0x000000FF;
		}

		return (b1 | b2 | b3 | b4);
	}

	public static short bytesToShort(byte[] array, int offset, boolean lowToHigh) {
		int b1, b2;
		if (!lowToHigh) {
			b1 = (array[offset++] << 8) & 0x0000FF00;
			b2 = (array[offset++] << 0) & 0x000000FF;
		} else {
			b1 = (array[offset + 1] << 8) & 0x0000FF00;
			b2 = (array[offset + 0] << 0) & 0x000000FF;
		}

		return (short) (b1 | b2);
	}

	public static long bytesToLonglong(byte[] array, int offset,
			boolean lowToHigh) {
		if (!lowToHigh) {
			return ((array[offset + 7] & 0xFFL) << 0)
					+ ((array[offset + 6] & 0xFFL) << 8)
					+ ((array[offset + 5] & 0xFFL) << 16)
					+ ((array[offset + 4] & 0xFFL) << 24)
					+ ((array[offset + 3] & 0xFFL) << 32)
					+ ((array[offset + 2] & 0xFFL) << 40)
					+ ((array[offset + 1] & 0xFFL) << 48)
					+ ((array[offset + 0] & 0xFFL) << 56);
		} else {
			return ((array[offset + 0] & 0xFFL) << 0)
					+ ((array[offset + 1] & 0xFFL) << 8)
					+ ((array[offset + 2] & 0xFFL) << 16)
					+ ((array[offset + 3] & 0xFFL) << 24)
					+ ((array[offset + 4] & 0xFFL) << 32)
					+ ((array[offset + 5] & 0xFFL) << 40)
					+ ((array[offset + 6] & 0xFFL) << 48)
					+ ((array[offset + 7] & 0xFFL) << 56);
		}

	}

}

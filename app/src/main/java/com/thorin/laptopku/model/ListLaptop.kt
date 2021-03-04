import android.os.Parcel
import android.os.Parcelable

data class ListLaptop (
        var namaLaptop: String? = "",
        var hargaLaptop: String? = "",
        var ketLaptop: String? = "",
        var spesifikasi: String? = "",
        var avatarLaptop: String? = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(namaLaptop)
        parcel.writeString(hargaLaptop)
        parcel.writeString(ketLaptop)
        parcel.writeString(spesifikasi)
        parcel.writeString(avatarLaptop)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ListLaptop> {
        override fun createFromParcel(parcel: Parcel): ListLaptop {
            return ListLaptop(parcel)
        }

        override fun newArray(size: Int): Array<ListLaptop?> {
            return arrayOfNulls(size)
        }
    }
}
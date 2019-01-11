package com.irmansyah.testmovie.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieResponse(var results: List<Movie>? = null)


data class Movie (@SerializedName("poster_path")
                  val posterPath: String? = null,
                  @SerializedName("adult")
                  val adult: Boolean = false,
                  @SerializedName("overview")
                  val overview: String? = null,
                  @SerializedName("release_date")
                  val releaseDate: String? = null,
                  @SerializedName("id")
                  val id: Int? = null,
                  @SerializedName("original_title")
                  val originalTitle: String? = null,
                  @SerializedName("original_language")
                  val originalLanguage: String? = null,
                  @SerializedName("title")
                  val title: String? = null,
                  @SerializedName("backdrop_path")
                  val backdropPath: String? = null,
                  @SerializedName("popularity")
                  val popularity: Double? = null,
                  @SerializedName("vote_count")
                  val voteCount: Int? = null,
                  @SerializedName("video")
                  val video: Boolean? = null,
                  @SerializedName("vote_average")
                  val voteAverage: Double? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Double::class.java.classLoader) as? Double
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(posterPath)
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
        parcel.writeValue(id)
        parcel.writeString(originalTitle)
        parcel.writeString(originalLanguage)
        parcel.writeString(title)
        parcel.writeString(backdropPath)
        parcel.writeValue(popularity)
        parcel.writeValue(voteCount)
        parcel.writeValue(video)
        parcel.writeValue(voteAverage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

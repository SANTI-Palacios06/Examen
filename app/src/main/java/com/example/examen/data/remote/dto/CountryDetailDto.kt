import com.example.examen.data.remote.dto.CountryNameDto
import com.google.gson.annotations.SerializedName

data class CountryDetailDto(
    @SerializedName("name") val name: CountryNameDto,
    @SerializedName("capital") val capital: List<String>?,
    @SerializedName("region") val region: String?,
    @SerializedName("subregion") val subregion: String?,
    @SerializedName("population") val population: Int?,
    @SerializedName("area") val area: Double?,
    @SerializedName("flags") val flags: FlagsDto,
    @SerializedName("borders") val borders: List<String>?
) {
    data class FlagsDto(
        @SerializedName("png") val png: String,
        @SerializedName("svg") val svg: String
    )
}
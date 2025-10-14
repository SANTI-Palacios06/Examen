import com.app.countryapp.data.mapper.toDomain
import com.app.countryapp.data.remote.api.CountryApi
import com.app.countryapp.domain.repository.CountryRepository
import com.example.examen.domain.model.Country
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepositoryImpl @Inject constructor(
    private val api: CountryApi
) : CountryRepository {

    override suspend fun getCountryList(): List<Country> {
        val response = api.getCountryList()
        return response.map { countryListDto ->
            countryListDto.toDomain()
        }
    }

    override suspend fun getCountryByName(name: String): Country {
        return api.getCountry(name).first().toDomain()
    }
}